from flask import Flask, jsonify, send_from_directory, redirect
import subprocess
import time
import os
from fetch import fetch_xml_from_db
from zivilizations import transform_xml_to_html

app = Flask(__name__)

@app.route("/")
def index():
    return redirect("/html/index.html")

@app.route('/html/<path:path>')
def send_html(path):
    return send_from_directory('html', path)

@app.route('/run-script', methods=['GET'])
def run_script():
    try:
        os.remove('./html/civilizations.html')
        fetch_xml_from_db('./xml/civilizations.xml')
        time.sleep(2)
        
        # Paths to XML and XSL files
        transformations = [
            ('./xml/attack_units.xml', './xml/attack_units.xsl', './html/attack_units.html'),
            ('./xml/buildings.xml', './xml/buildings.xsl', './html/buildings.html'),
            ('./xml/defences.xml', './xml/defences.xsl', './html/defences.html'),
            ('./xml/special_units.xml', './xml/special_units.xsl', './html/special_units.html'),
            ('./xml/civilizations.xml', './xml/civilizations.xsl', './html/civilizations.html')
        ]
        
        # Delete civilizations.html if it exists
        file_path = './html/civilizations.html'
        if os.path.exists(file_path):
            os.remove(file_path)
            print(f'El archivo {file_path} ha sido borrado.')
        else:
            print(f'El archivo {file_path} no existe.')
        
        # Transform XML to HTML
        for xml_path, xsl_path, output_path in transformations:
            transform_xml_to_html(xml_path, xsl_path, output_path)
        
        # Run the zivilizations.py script
        subprocess.run(['python', './zivilizations.py'], check=True)
        
        response = jsonify({'status': 'success', 'message': 'Página refrescada.'})
        response.headers.add('Access-Control-Allow-Origin', '*')
        return response
    except subprocess.CalledProcessError as e:
        response = jsonify({'status': 'error', 'message': str(e)})
        response.headers.add('Access-Control-Allow-Origin', '*')
        return response, 500

if __name__ == '__main__':
    print("initializing flask")
    app.run(host='0.0.0.0', port=5000)

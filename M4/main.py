from flask import Flask, jsonify, send_from_directory, redirect
import subprocess
import time
import os
from fetch import fetch_xml_from_db
from zivilizations import transform_xml_to_html

app = Flask(__name__)

@app.route("/")
def index():
    return redirect("/HTML/index.html")

@app.route('/HTML/<path:path>')
def send_html(path):
    return send_from_directory('HTML', path)

@app.route('/run-script', methods=['GET'])
def run_script():
    try:
        fetch_xml_from_db('./xml/civilizations.xml')
        time.sleep(2)
        file_path = '/html/civilizations.html'
        if os.path.exists(file_path):
            os.remove(file_path)
            print(f'El archivo {file_path} ha sido borrado.')
        else:
            print(f'El archivo {file_path} no existe.')
        xml_path1 = './xml/attack_units.xml'
        xsl_path1 = './xml/attack_units.xsl'
        output_path1 = './html/attack_units.html'
        xml_path2 = './xml/buildings.xml'
        xsl_path2 = './xml/buildings.xsl'
        output_path2 = './html/buildings.html'
        xml_path3 = './xml/defences.xml'
        xsl_path3 = './xml/defences.xsl'
        output_path3 = './html/defences.html'
        xml_path4 = './xml/special_units.xml'
        xsl_path4 = './xml/special_units.xsl'
        output_path4 = './html/special_units.html'
        xml_path5 = './xml/civilizations.xml'
        xsl_path5 = './xml/civilizations.xsl'
        output_path5 = './html/civilizations.html'
        transform_xml_to_html(xml_path1, xsl_path1, output_path1)
        transform_xml_to_html(xml_path2, xsl_path2, output_path2)
        transform_xml_to_html(xml_path3, xsl_path3, output_path3)
        transform_xml_to_html(xml_path4, xsl_path4, output_path4)
        transform_xml_to_html(xml_path5, xsl_path5, output_path5)
        subprocess.run(['python', './zivilizations.py'], check=True)
        return jsonify({'status': 'success', 'message': 'Página refrescada.'})
    except subprocess.CalledProcessError as e:
        return jsonify({'status': 'error', 'message': str(e)}), 500

print(__name__)
if __name__ == '__main__':
    print("initializing flask")
    app.run(host='0.0.0.0', port=5000)
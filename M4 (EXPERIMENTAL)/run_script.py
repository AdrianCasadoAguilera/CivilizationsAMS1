from flask import Flask, jsonify, send_from_directory
import subprocess
import time
import os

app = Flask(__name__)

# Ruta para servir archivos estáticos (por ejemplo, archivos JavaScript)
@app.route('/HTML/<path:path>')
def send_html(path):
    return send_from_directory('HTML', path)

@app.route('/run-script', methods=['GET'])
def run_script():
    try:
        subprocess.run(['python', './fetch.py'], check=True)
        time.sleep(2)
        subprocess.run(['python', './zivilizations.py'], check=True)
        return jsonify({'status': 'success', 'message': 'Página refrescada.'})
    except subprocess.CalledProcessError as e:
        return jsonify({'status': 'error', 'message': str(e)}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)

from flask import Flask, jsonify
import subprocess
import time

app = Flask(__name__)

@app.route('/run-script', methods=['GET'])
def run_script():
    try:
        subprocess.run(['python', './fetch.py'], check=True)
        time.sleep(2)
        subprocess.run(['python', './zivilizations.py'], check=True)
        return jsonify({'status': 'success', 'message': 'Scripts ejecutados correctamente.'})
    except subprocess.CalledProcessError as e:
        return jsonify({'status': 'error', 'message': str(e)}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)

from flask import Flask
from flask import render_template
from flask import request

app = Flask(__name__)

@app.route("/")
def index():
    return render_template('FlaskTest.html')


@app.route('/skelly')
def skelly():
    return render_template('skellyIndex.html')
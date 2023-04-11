# importações
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
import os

# flask
app = Flask(__name__)

utilizar = "sqlite"
#utilizar = "mysql"

# comando mágico necessário a partir do python 10
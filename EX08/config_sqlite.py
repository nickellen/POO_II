from config_comum import *

# sqlalchemy com sqlite
path = os.path.dirname(os.path.abspath(__file__)) 
arquivobd = os.path.join(path, 'monique_sqlite_tables.db')
app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///"+arquivobd
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)

app.app_context().push()
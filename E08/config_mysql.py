from config_comum import *

# sqlalchemy com mysql
#app.config['SQLALCHEMY_DATABASE_URI'] = "mysql+pymysql://hylsonco_poo2_user:ifcPoo2!#$@51.222.203.22/hylsonco_poo2"
#app.config['SQLALCHEMY_DATABASE_URI'] = "mysql+pymysql://root:testando@191.52.7.111/hylson_poo2"
app.config['SQLALCHEMY_DATABASE_URI'] = "mysql+pymysql://root:iamon1428@127.0.0.115:3306/mysql_table"
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
db = SQLAlchemy(app)

app.app_context().push()
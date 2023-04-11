import mysql.connector

mydb = mysql.connector.connect(
    host = "localhost",
    user="root",
    passwd = "password123"
)

my_cursor = mydb.cursor()

my_cursor.execute("CREATE DATABASE monique_mysql_table")

my_cursor.execyte("SHOW DATABASES")
for db in my_cursor:
    print(db)
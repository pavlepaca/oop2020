import pymysql
import datetime
from datetime import datetime
import json as j

import flask as f
from flask import Flask
from flask import request
from flaskext.mysql import MySQL

app=Flask(__name__,static_url_path="")

mysql=MySQL(cursorclass=pymysql.cursors.DictCursor)

app.config["MYSQL_DATABASE_USER"] = "root"
app.config["MYSQL_DATABASE_PASSWORD"] = "pavleperic"
app.config["MYSQL_DATABASE_DB"] = "prodavnica_patika"
app.config["MYSQL_DATABASE_HOST"] = "localhost"

mysql.init_app(app)

#pocetna
@app.route("/")
@app.route("/pocetna")
def pocetna():
    return f.send_from_directory("static/templates","pocetna.html")

#registracija
@app.route("/registracija")
def registracija():
    return f.send_from_directory("static/templates","registracija.html")



@app.route("/dodavanjeNovePatike")
def patika():
    return f.send_from_directory("static/templates","novaPatika.html")


#login
@app.route("/prijava")
def prijava():
    return f.send_from_directory("static/templates","login.html")








#Dobavljanje korisnika
@app.route("/korisnici",methods=["POST"])
def dobaviKorisnike():
    data = request.json
    cursor = mysql.get_db().cursor()
    cursor.execute("SELECT * FROM korisnici")
    korisnici = cursor.fetchall()

    for korisnik in korisnici : 
        if korisnik["korisnicko_ime"]==data["korisnickoIme"]:
            if korisnik["lozinka"]==data["lozinka"]:
                return f.jsonify(korisnik["id"])

    
    return f.jsonify({"status" : "pogresno"})

#Dobavljanje patika
@app.route("/patike",methods=["GET"])
def dobaviPatike():
    cursor = mysql.get_db().cursor()
    cursor.execute("SELECT * FROM patike")
    rows = cursor.fetchall()
    return f.jsonify(rows)

#Dobavljanje kupovina
@app.route("/kupovine",methods=["GET"])
def dobaviKupovine():
    cursor = mysql.get_db().cursor()
    cursor.execute("SELECT * FROM kupovine")
    rows = cursor.fetchall()
    return f.jsonify(rows)


#Dobavljnje jednog korisnika po ID
@app.route("/korisnici/<int:id>",methods=["GET"])
def dobaviKorisnika(id):
    cursor = mysql.get_db().cursor()
    cursor.execute("SELECT * FROM korisnici WHERE id=%s",id)
    rows = cursor.fetchone()
    return f.jsonify(rows)

#Dobavljanje jedne patike po ID
@app.route("/patike/<int:id>",methods=["GET"])
def dobaviPatiku(id):
    cursor = mysql.get_db().cursor()
    cursor.execute("SELECT * FROM patike WHERE id=%s",id)
    rows = cursor.fetchone()
    return f.jsonify(rows)

#Dobavljanje jedne kupovine po ID
@app.route("/kupovine/<int:id>",methods=["GET"])
def dobaviKupovinu(id):
    cursor = mysql.get_db().cursor()
    cursor.execute("SELECT * FROM kupovine WHERE id=%s",id)
    rows = cursor.fetchone()
    return f.jsonify(rows)




#Brisanje patike 
@app.route("/patike/<int:id>",methods=["DELETE"])
def ukloniPatiku(id):
    db = mysql.get_db()
    cursor = db.cursor()
    cursor.execute("DELETE FROM patike WHERE id=%s",id)
    db.commit()

    return ""




#Dodavanje korisnika
@app.route("/dodajKorisnika",methods=["POST"])
def dodajKorisnika():
    data = request.json
    db = mysql.get_db()
    cursor = db.cursor()

    q = '''INSERT INTO
    korisnici(korisnicko_ime, lozinka, ime, prezime, adresa, email,  telefon, admin)
    VALUES(%s, %s,%s, %s,%s, %s, %s,%s)'''

    cursor.execute(q,(data["korisnicko_ime"],data["lozinka"],data["ime"],
    data["prezime"],data["adresa"],data["email"],data["telefon"],data["admin"]))

    db.commit()
    return f.jsonify({"status" : "done"}),201

#Dodavanje patike
@app.route("/dodavanjePatike",methods=["POST"])
def dodajPatiku():
    data = request.json
    db = mysql.get_db()
    cursor = db.cursor()

    q = '''INSERT INTO
    patike(naziv, brend, namena, cena, slika)
    VALUES(%s, %s,%s, %s,%s)'''

    cursor.execute(q,(data["naziv"],data["brend"],data["namena"],
    data["cena"],data["slika"]))

    db.commit()
    return f.jsonify({"status" : "done"}),201


#Dodavanje kupovine
@app.route("/dodavanjeKupovine",methods=["POST"])
def dodajKupovinu():
    data = request.json
    db = mysql.get_db()
    cursor = db.cursor()

    q = '''INSERT INTO
    kupovine(datum, korisnik_id, patika_id, patika_cena)
    VALUES(%s, %s, %s, %s)'''

    trenutnoVreme = datetime.now()
    datum_vreme = trenutnoVreme.strftime('%Y-%m-%d %H:%M:%S')

    data["datum"] = datum_vreme
    cursor.execute(q, (data["datum"], data["korisnik_id"],data["patika_id"],data["patika_cena"]))

    db.commit()
    return f.jsonify({"status": "done"}), 201


#Izmena korisnika

@app.route("/korisnici/<int:id>", methods=["PUT"])
def izmeniKorisnika(id):
    data = request.json
    db = mysql.get_db()
    cursor = db.cursor()
    q = '''UPDATE korisnici SET korisnicko_ime=%s, lozinka=%s, ime=%s, prezime=%s, adresa=%s, email=%s,  telefon=%s WHERE id=%s'''
    

    cursor.execute(q,(data["korisnicko_ime"],data["lozinka"],data["ime"],
    data["prezime"],data["adresa"],data["email"],data["telefon"], id))
    db.commit()
    return ""

#Izmena patike

@app.route("/patike/<int:id>", methods=["PUT"])
def izmeniPatiku(id):
    data = request.json
    db = mysql.get_db()
    cursor = db.cursor()
    q = '''UPDATE patike SET naziv=%s, brend=%s, namena=%s, cena=%s, slika=%s WHERE id=%s'''
    

    cursor.execute(q,(data["naziv"],data["brend"],data["namena"],
    data["cena"],data["slika"], id))
    db.commit()
    return ""






app.run(host="localhost",debug=True,threaded=True)


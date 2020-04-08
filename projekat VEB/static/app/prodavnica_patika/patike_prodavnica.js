(function (angular) {
    var app = angular.module("Aplikacija");

    app.controller("ListaKorisnika", function ($http) {
        
        var lk = this;

        lk.korisnici = [];

        lk.noviKorisnik = {
            "korisnicko_ime":"",
            "lozinka" : "",
            "ime": "",
            "prezime": "",
            "adresa" : "",
            "email" : "",
            "telefon" : "",
            "admin" : 0
        };

        var korisnicko_ime = "";
        var lozinka = "";
        
        lk.prijavljenKorisnik = {"korisnickoIme" : "","lozinka" : ""};

        lk.zaIzmenuKorisnika = {};

        lk.korisnik = {}
        
        
        // Dobavljanje svih korisnika
        lk.dobaviKorisnike = function() {
            $http.post("/korisnici",lk.prijavljenKorisnik).then(function(response) {
                if (response.data.status != "pogresno"){
                    window.sessionStorage.setItem("id" , response.data);
                    window.location.replace("/pocetna");
                } 
                else{
                    window.alert("Pogresni podaci");
                }
                
            }, function(reason) {
                console.log(reason);
            });
        }
        

    
        //Funkcija za dobavljanje Korisnika
        lk.dobaviKorisnika = function(id) {
            $http.get("/korisnici/"+id).then(function(response){
                lk.korisnik = response.data;
            },
            function(reason){
                console.log(reason);
            });
        };

        lk.dodajNovogKorisnika = function(){
            $http.post("/dodajKorisnika", lk.noviKorisnik).then(function(response){
                lk.dobaviKorisnike();
                window.location.replace("/");
            },
            function(reason){
                console.log(reason)
            });

           
        };






        lk.ukloniKorisnika = function(id) {

            $http.delete("/korisnici/"+id).then(function(response){
                lk.dobaviKorisnike();
            },
            function(reason){
                console.log(reason)
            });
        };






        lk.pripremiZaIzmenuKorisnika = function(korisnik) {
            lk.zaIzmenuKorisnika = angular.copy(korisnik);
            document.getElementById("izmenaKorisnika").style.display="block";
        }

        lk.odustaniOdIzmene = function() {
            lk.zaIzmenuKorisnika = {};
        }



        //Funkcija za menjanje podataka korisnika
        lk.izmeniKorisnika = function() {

            $http.put("/korisnici/"+lk.zaIzmenuKorisnika.id, lk.zaIzmenuKorisnika).then(function(response){
                lk.dobaviKorisnika(window.sessionStorage.getItem("id"));
                document.getElementById("izmenaKorisnika").style.display="none";
                lk.zaIzmenuKorisnika = {};
                
            },
            function(reason){
                console.log(reason)
            });
        }




        //Provera sesije
        lk.proveriSesiju = function(){
            if(window.location.href.match("/prijava") || window.location.href.match("/registracija")){
                return;
            }
            else{
                if(window.sessionStorage.getItem("id") === null){
                    window.location.replace("/prijava");
                    return;
                }
                else{
                    lk.dobaviKorisnika(window.sessionStorage.getItem("id"));
                    return;
                }
            }
        }


        
        lk.proveriSesiju();
        
        

    });



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



app.controller("ListaPatika", function ($http) {
    
    var lt = this;

    lt.novaPatika = {
        "naziv":"",
        "brend" : "",
        "namena": "",
        "cena": "",
        "slika" : ""
    };

    lt.patike = [];
    lt.patike = {}

    lt.zaIzmenuPatike={};
    lt.sort="";

    lt.rastuce=function(){
        lt.sort = "cena";
    }
    lt.opadajuce=function(){
        lt.sort = "-cena";
    }
    
    
    // Dobavljanje svih patika
    lt.dobaviPatike = function() {
        $http.get("/patike").then(function(response) {
            lt.patike = response.data;
        }, function(reason) {
            console.log(reason);
        });
    }


    

    //Funkcija za dobavljanje patike
    lt.dobaviPatiku = function(id) {

        $http.get("/patike/"+id).then(function(response){
            lt.patike = response.data;
        },
        function(reason){
            console.log(reason)
        });
    }

    lt.dodajNovuPatiku = function(){
        $http.post("/dodavanjePatike",lt.novaPatika).then(function(response){
            lt.dobaviPatike();
            window.location.replace("/pocetna");
        },
        function(reason){
            console.log(reason);
        })
    }

    lt.pripremiZaIzmenuPatike = function(patika) {
        lt.zaIzmenuPatike = angular.copy(patika);
        document.getElementById("izmenaPatike").style.display="block";
    }

    lt.odustaniOdIzmenePatike = function() {
        lt.zaIzmenuPatike = {};
    }



    //Funkcija za menjanje podataka patike
    lt.izmeniPatiku = function() {

        $http.put("/patike/"+lt.zaIzmenuPatike.id, lt.zaIzmenuPatike).then(function(response){
            lt.dobaviPatike();
            document.getElementById("izmenaPatike").style.display="none";
            lt.zaIzmenuPatike = {};
            
        },
        function(reason){
            console.log(reason)
        });
    }


    // Funkcija za brisanje patike
    lt.ukloniPatiku = function(id) {

        $http.delete("/patike/"+id).then(function(response){
            lt.dobaviPatike();
        },
        function(reason){
            console.log(reason)
        });
    };



   lt.izlogujSe = function(){
    window.sessionStorage.clear();
    window.location.replace("/prijava");

    
}



    //Provera sesije
    lt.proveriSesiju = function(){
        if(window.location.href.match("/prijava") || window.location.href.match("/registracija")){
            return;
        }
        else{
            if(window.sessionStorage.getItem("id") === null){
                window.location.replace("/prijava");
                return;
            }
            else{
                return;
            }
        }
    }


    lt.dodajIdPatike=function(patika){
        window.sessionStorage.setItem("cena",patika["cena"]);
        window.sessionStorage.setItem("id_patike",patika["id"]);
    }

    lt.proveriSesiju();
    lt.dobaviPatike();


});


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

app.controller("ListaKupovina", function ($http) {
        
    var ll = this;

    ll.kupovine = [];

    ll.novaKupovina = {
        "datum":"",
        "korisnik_id" : "",
        "patika_id": "",
        "patika_cena":""

    };

    ll.patika_cena="";
    ll.patika_id="";

    ll.zaIzmenu = {};

    ll.kupovina = {}
    
    
    // Dobavljanje svih kupovina
    ll.dobaviKupovine = function() {
        $http.get("/kupovine").then(function(response) {
            ll.kupovine = response.data;
        }, function(reason) {
            console.log(reason);
        });
    }
    

    //Funkcija za dodavanje nove kupovine.
    ll.dodajKupovinu = function(patika) {
        ll.novaKupovina["korisnik_id"]=window.sessionStorage.getItem("id");
        ll.novaKupovina["patika_id"]=patika["id"];
        ll.novaKupovina["patika_cena"]=patika["cena"];
        window.alert("Uspesno ste narucili patike");
        $http.post("/dodavanjeKupovine", ll.novaKupovina).then(function(response){
           
        },
        function(reason){
            console.log(reason);
        })
    };




    //Funkcija za dobavljanje kupovine
    ll.dobaviKupovinu= function(id) {

        $http.get("/kupovine/"+id).then(function(response){
            ll.kupovina = response.data;
        },
        function(reason){
            console.log(reason)
        });
    };


    //Funkcija za uklanjanje kupovine
    ll.ukloniKupovinu = function(id) {

        $http.delete("/kupovine/"+id).then(function(response){
            ll.dobaviKupovine();
        },
        function(reason){
            console.log(reason)
        });
    };



    ll.dobaviKupovine();
});

})(angular);



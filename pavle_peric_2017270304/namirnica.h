#ifndef NAMIRNICA_H_INCLUDED
#define NAMIRNICA_H_INCLUDED
#include <iostream>
using namespace std;
class Namirnica{
    public:
        string naziv;
        int energetska;
        int kolicina;
        int cena;
        Namirnica(string naziv, int energetska, int kolicina, int cena);

        virtual void detalji(){
        cout<< "Namirnica " <<naziv<< "-" <<kolicina<< "kg "<<" kosta"<< cena<< "rsd i ima energetsku vrednost "<<energetska<<"\n";
        }


};

#endif // NAMIRNICA_H_INCLUDED

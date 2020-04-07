#ifndef POVRCE_H_INCLUDED
#define POVRCE_H_INCLUDED
#include <iostream>
using namespace std;
class Povrce:Namirnica{
    public:
        int hidrati;
        int seceri;
        Povrce(int hidrati, int seceri):Namirnica(naziv, energetska, kolicina, cena);

        virtual void detalji(){
        cout<< "Namirnica " <<naziv<< "-" <<kolicina<< "kg "<<" kosta"<< cena<< "rsd i ima energetsku vrednost "<<energetska<<". Procenat ugljenih hidrata "<<hidrati<< "od cega su seceri "<<seceri<<"\n";
        }

};


#endif // POVRCE_H_INCLUDED

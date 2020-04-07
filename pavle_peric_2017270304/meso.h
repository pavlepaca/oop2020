#ifndef MESO_H_INCLUDED
#define MESO_H_INCLUDED
#include <iostream>
using namespace std;
class Meso:Namirnica{
    public:
        string tip;
        int masti;
        int proteini;
        Meso(string tip, int masti, int proteini): Namirnica(naziv, energetska, kolicina, cena);

        virtual void detalji(){
            cout<< "Namirnica " <<naziv<< "-" <<kolicina<< "kg "<<" kosta"<< cena<< "rsd i ima energetsku vrednost "<<energetska<<tip<< "od cega "<<masti<<"masti i "<<proteini<<"proteina "<<"\n";
        }

        virtual void klasa(){
            if(masti<=10)
                cout<<"Klasa 3"<<"\n";
            else if(masti>10 && masti<15)
                cout<<"Klasa 2"<<"\n";
            else if(masti>=15 && masti<25)
                count<<"Klasa 1"<<"\n";
        }


};



#endif // MESO_H_INCLUDED

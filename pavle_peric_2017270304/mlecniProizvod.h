#ifndef MLECNIPROIZVOD_H_INCLUDED
#define MLECNIPROIZVOD_H_INCLUDED
#include <iostream>
using namespace std;
class MlecniProizvod:Namirnica{
    public:
        enum tip{svez, pasterizovan, fermentisan};
        int mmasti;
        int rok;
        MlecniProizvod(enum tip, int mmasti, int rok):Namirnica(naziv, energetska, kolicina, cena);

        virtual bool ispravnost(){
            if(rok>0)
                return true;
            else
                return false;
        }

        virtual void detalji(){
        cout<< "Namirnica " <<naziv<< "-" <<kolicina<< "kg "<<" kosta"<< cena<< "rsd i ima energetsku vrednost "<<energetska<<". Procenat mlecne masti "<<mmasti<<".Preostalo dana do isteka roka: "<<rok<<"\n";
        }

};


#endif // MLECNIPROIZVOD_H_INCLUDED

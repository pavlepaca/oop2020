#ifndef RECEPT_H_INCLUDED
#define RECEPT_H_INCLUDED
#include <iostream>
using namespace std;
class Recept{
    vector<Namirnica*> namirnice;
    string postupak;

    void dodajNamirnicu(namirnica){
        namirnice.insert(namirnica);
        cout<<"Dodata namirnica "<< namirnica<<"\n";
    }

    virtual void detalji(){
        for(size_t i=0; i<namirnice.size(); ++i){
        cout << namirnice[i] << "\n"}

    }
};


#endif // RECEPT_H_INCLUDED

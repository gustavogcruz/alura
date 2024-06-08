#include <iostream>
#include "chuta.hpp"
#include "letra_existe.hpp"
using namespace std;


void chuta(map<char, bool>& chutou, vector<char>& chutes_errados, string& palavra_secreta)
{
    cout << "Seu chute: ";
    char chute;
    cin >> chute;

    chutou[chute] = true;

    if(letra_existe(chute, palavra_secreta)){
        cout << "Você acertou! Seu chute está na palavra." << endl;
    }
    else{
        cout << "Você errou! Seu chute não está na palavra." << endl;
        chutes_errados.push_back(chute);
    }
    cout << endl;
}
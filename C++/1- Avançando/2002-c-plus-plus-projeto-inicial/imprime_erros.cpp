#include <iostream>
#include "imprime_erros.hpp"
using namespace std;

    void forca::imprime_erros(const vector<char>& chutes_errados) {

        cout << "Chutes errados: ";
        for (char letra : chutes_errados) {
            cout << letra << " ";
        }
        cout << endl;
    }
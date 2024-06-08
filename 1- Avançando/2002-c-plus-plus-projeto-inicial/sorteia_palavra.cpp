#include <vector>
#include <ctime>
#include "le_arquivo.hpp"

using namespace std;

string sorteia_palavra(){
    vector<string> palavras = le_arquivo();

    srand((unsigned int) time(NULL));
    int indice_sorteado = rand() % palavras.size();

    return palavras[indice_sorteado];
}
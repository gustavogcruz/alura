#include "nao_acertou.hpp"

bool nao_acertou(string& palavra_secreta, const map<char, bool>& chutou){

    for(char letra : palavra_secreta){
        if(chutou.find(letra) == chutou.end() || !chutou.at(letra)){
            return true;
        }
    }
    return false;
}

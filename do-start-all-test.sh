#!/bin/bash

# Esegue tutti gli script in questo progetto

## Init methods
echo
echo "===== Inizializzazione dei database ====="

# Inizializzazione enigmi
echo
echo "do-init-enigmi.sh"
./do-init-enigmi.sh
echo
echo "do-post-altri-enigmi.sh"
./do-post-altri-enigmi.sh

# Inizializzazione connessioni
echo
echo "do-init-connessioni.sh"
./do-init-connessioni.sh
echo
echo "do-post-altre-connessioni.sh"
./do-post-altre-connessioni.sh

## Get methods
echo
echo "===== Test dei metodi di GET ====="

echo
echo "do-get-enigmi.sh"
./do-get-enigmi.sh

echo
echo "do-get-connessioni.sh"
./do-get-connessioni.sh

# Get enigmi seguiti da Utente
echo "----- Enigmi seguiti da {Utente} -----"
echo
echo "do-get-enigmi-seguiti Alice"
./do-get-enigmi-seguiti.sh Alice
echo
echo "do-get-enigmi-seguiti Barbara"
./do-get-enigmi-seguiti.sh Barbara
echo
echo "do-get-enigmi-seguiti Carlo"
./do-get-enigmi-seguiti.sh Carlo
echo
echo "do-get-enigmi-seguiti Enrico"
./do-get-enigmi-seguiti.sh Enrico
echo
echo "do-get-enigmi-seguiti Donatella"
./do-get-enigmi-seguiti.sh Donatella

# Get enigmi di tipo
echo "----- Enigmi per {Tipo} -----"
echo
echo "do-get-enigmi-di-tipo Indovinello"
./do-get-enigmi-di-tipo.sh Indovinello
echo
echo "do-get-enigmi-di-tipo Cambio"
./do-get-enigmi-di-tipo.sh Cambio
echo
echo "do-get-enigmi-di-tipo Anagramma"
./do-get-enigmi-di-tipo.sh Anagramma
echo
echo "do-get-enigmi-di-tipo Spostamento"
./do-get-enigmi-di-tipo.sh Spostamento

# GEt enigmi di autore
echo "----- Enigmi per {Autore} -----"
echo
echo "do-get-enigmi-di-autore.sh Azimut"
./do-get-enigmi-di-autore.sh Azimut
echo
echo "do-get-enigmi-di-autore.sh Turandot"
./do-get-enigmi-di-autore.sh Turandot
echo
echo "do-get-enigmi-di-autore.sh Il Mancino"
./do-get-enigmi-di-autore.sh "Il Mancino"
echo
echo "do-get-enigmi-di-autore.sh Il Valletto"
./do-get-enigmi-di-autore.sh "Il Valletto"
echo
echo "do-get-enigmi-di-autore.sh Radar"
./do-get-enigmi-di-autore.sh Radar
echo
echo "do-get-enigmi-di-autore.sh Donatella"
./do-get-enigmi-di-autore.sh Donatella
echo
echo "do-get-enigmi-di-autore.sh Dendi"
./do-get-enigmi-di-autore.sh Dendi
echo
echo "do-get-enigmi-di-autore.sh Body"
./do-get-enigmi-di-autore.sh Body
import { useState, useEffect } from "react";
import { Pet } from '../../@types/Pet';
import { ApiService } from '../../services/ApiService';
import { AxiosError } from "axios";

export function useIndex() {
  const [listPets, setListPets] = useState<Pet[]>([]),
    [petSelected, setPetSelected] = useState<Pet | null>(null),
    [email, setEmail] = useState(''),
    [valor, setValor] = useState(''),
    [message, setMessage] = useState('');

  useEffect(() => {
    ApiService.get('/pets').then((resposta) => {
      setListPets(resposta.data);
    })
  }, [])

  useEffect(() => {
    if(petSelected === null) {
      clearForm();
    }
  }, [petSelected])

  function adotar(){
    if(petSelected !== null) {
        if(validatorDataAdocao()) {
            ApiService.post('/adocoes', {
              pet_id: petSelected.id,
              email,
              valor
            })
              .then(() => {
                  setPetSelected(null);
                  setMessage('Pet adotado com sucesso!');
              })
              .catch((error: AxiosError | any) => {
                  setMessage(error.response?.data.message);
              })
        } else {
          setMessage('Preencha todos os campos corretamente!');
        }
    }
  }

  function validatorDataAdocao(){
    return email.length > 0 && valor.length > 0;
  }

  function clearForm() {
      setEmail('');
      setValor('');
  }

  return {
    listPets,
    petSelected,
    setPetSelected,
    email,
    setEmail,
    valor,
    setValor,
    message,
    setMessage,
    adotar
  };
}
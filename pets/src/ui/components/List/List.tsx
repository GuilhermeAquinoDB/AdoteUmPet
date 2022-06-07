import { Button } from '@mui/material';
import { Pet } from '../../../data/@types/Pet';
import {ListStyled, ItemList, Photo, Information, Name, Description} from './List.style';
import { TextService} from '../../../data/services/TextService';

interface ListProps {
  pets: Pet[];
}

export default function List(props: ListProps) {
  const tamanhoMaximoTexto = 200;

  return (
    <ListStyled>
      {props.pets.map(pet => (
          <ItemList key={pet.id} >
            <Photo src={pet.photo} alt={pet.name} />
            <Information>
                <Name>{pet.name}</Name>
                <Description>
                    {TextService.limitarTexto(pet.history, tamanhoMaximoTexto)}
                  </Description>
                <Button 
                  variant={'contained'} 
                  fullWidth >
                    Adotar {pet.name}
                </Button>
            </Information>
          </ItemList>
      ))}
    </ListStyled>
  )
}
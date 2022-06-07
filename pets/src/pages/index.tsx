import type { NextPage } from 'next'
import List from '../ui/components/List/List';
import Title from '../ui/components/Title/Title';
import { Dialog, TextField, Grid, DialogActions, Button, Snackbar } from '@mui/material';

const Home: NextPage = () => {
  return (
    <div>
     <Title 
        title="" 
        subtitle={
          <span>Com um pequeno valor mensal, você <br /> 
            <strong> pode adotar um pet virtualmente</strong>
          </span>
      } />
      <List 
        pets={[
          {
            id: 1,
            name: 'Oscar',
            history: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ex dolorem officia nulla libero quae iure aspernatur expedita, eveniet aliquam magni, impedit culpa dicta labore assumenda consectetur quaerat delectus maiores perspiciatis.',
            photo: 'https://media.istockphoto.com/photos/its-a-paddle-board-time-picture-id1327654972'
          },
          {
            id: 2,
            name: 'Lálá',
            history: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ex dolorem officia nulla libero quae iure aspernatur expedita, eveniet aliquam magni, impedit culpa dicta labore assumenda consectetur quaerat delectus maiores perspiciatis.',
            photo: 'https://images.unsplash.com/photo-1561037404-61cd46aa615b'
          }
        ]}
      />

      <Dialog 
        open={false}
        fullWidth
        PaperProps={{ sx: { p: 5 }}}
      >
        <Grid container spacing={2} >
          <Grid item xs={12} >
            <TextField 
              label={'E-mail'}
              type={'email'}
              fullWidth
            />
          </Grid>
          <Grid item xs={12} >
            <TextField 
              label={'Quantia por mês'}
              type={'number'}
              fullWidth
            />
          </Grid>
        </Grid>
        <DialogActions sx={{mt: 5}} >
            <Button color={'secondary'}>
              Cancelar
            </Button>
            <Button variant={'contained'}>
              Confirmar adoção
            </Button>
        </DialogActions>
      </Dialog>

      <Snackbar 
        open={true}
        message={'boa boa boa'}
      />
    </div>
  )
}

export default Home

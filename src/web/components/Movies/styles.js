import { makeStyles } from '@material-ui/core/styles';

export default makeStyles(() => ({
  root: {
    marginTop: '5%',
    maxWidth: '90%',
  },
  media: {
    height: 0,
    paddingTop: '80%',
  },
  cardActions: {
    display: 'flex',
    justifyContent: 'flex-end',
  },
  cardContent: {
    display: 'flex',
    justifyContent: 'space-between',
    fontWeight: 900
  }
}));
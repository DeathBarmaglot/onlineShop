import React from 'react';
import Grid from '@material-ui/core/Grid';

import Product from './Product/Product';
import useStyles from './styles';

const products = [
  { id: 1, name: "Moon Knight", description: "Marvell", price: '10', image :  'https://static.hdrezka.ac/i/2021/11/29/me526bdb7ea5dad36a32g.jpg' },
  { id: 2, name: "Venom", description: "DC" , price: '15' , image: 'https://static.hdrezka.ac/i/2022/3/11/la1c4f936b11ctn49p58t.jpg' },
];

const Products = ({ prodSucts, onAddToCart }) => {
  const classes = useStyles();

  console.log(products);
  return (
    <main className={classes.content}>
      <div className={classes.toolbar} />
      <Grid container justify="center" spacing={4}>
        {products.map((product) => (
          <Grid key={product.id} item xs={12} sm={6} md={4} lg={3}>
            <Product product={product} />
          </Grid>
        ))}
      </Grid>
    </main>
  );
};

export default Products;
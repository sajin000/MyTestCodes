import React from 'react'
import PropTypes from 'prop-types'
import './cart.css';

const Product = ({ price, quantity, name ,image }) => (
  <div>
    {name} - &#36;{price}{quantity ? ` x ${quantity}` : null}
      <img src={image} alt='cart'/>
    
  </div>
  
)

Product.propTypes = {
  price: PropTypes.number,
  quantity: PropTypes.number,
  name: PropTypes.string,
  image: PropTypes.string
}

export default Product

import React, { useContext } from "react";
import { CartContext } from "../contexts/CartContext";

function Item({ itemData }) {
  const { cart, dispatch } = useContext(CartContext);

  const addToCart = () => {
    dispatch({ type: "ADD_TO_CART", payload: itemData });
  };

  const itemInCart = cart.items.find((item) => item.id === itemData.id);
  const itemQuantity = itemInCart ? itemInCart.quantity : 0;

  return (
    <div className="card mx-3 my-3 d-flex" style={{ width: "18rem" }}>
      <img className="card-img-top" src={itemData.photoUrl} alt="" />
      <div className="card-body">
        <div className="d-flex justify-content-between">
          <h5 className="card-title">{itemData.name}</h5>
          <h6 className="card-title">{itemData.price}$</h6>
        </div>
        <p className="card-text">{itemData.description}</p>
        <div className="d-flex justify-content-between align-items-center">
          <button className="btn btn-primary" onClick={addToCart}>
            Add to Cart
          </button>
          {itemQuantity > 0 && (
            <span className="badge badge-pill badge-danger">
              {itemQuantity}
            </span>
          )}
        </div>
      </div>
    </div>
  );
}

export default Item;

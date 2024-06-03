import React, { useContext } from "react";
import { CartContext } from "../contexts/CartContext";
import { createOrder } from "../services/OrderService";

function Cart() {
  const { cart, dispatch } = useContext(CartContext);

  const removeFromCart = (id) => {
    dispatch({ type: "REMOVE_FROM_CART", payload: { id } });
  };

  const decrementQuantity = (id) => {
    dispatch({ type: "DECREMENT_QUANTITY", payload: { id } });
  };

  const incrementQuantity = (id) => {
    dispatch({
      type: "ADD_TO_CART",
      payload: cart.items.find((item) => item.id === id),
    });
  };

  const handleCheckout = async () => {
    console.log(cart);
    try {
      const response = await createOrder(cart);
      if (response.statusCode === 200) {
        // Handle successful checkout
        console.log(response.data);
        window.location.href = response.data.orderPayment.paymentUrl;
        console.log("Checkout successful!");
      } else {
        // Handle error response
        console.error("Checkout failed:");
      }
    } catch (error) {
      // Handle network error
      console.error("Network error:");
    }
  };

  return (
    <div className="container">
      <h1 className="text-center">Cart Summary</h1>
      {cart.items.length === 0 ? (
        <p>No items in cart</p>
      ) : (
        <table className="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Price</th>
              <th scope="col">Quantity</th>
              <th scope="col">Total</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {cart.items.map((item, index) => (
              <tr key={item.id}>
                <th scope="row">{index + 1}</th>
                <td>{item.name}</td>
                <td>{item.price}$</td>
                <td>{item.quantity}</td>
                <td>{(item.price * item.quantity).toFixed(2)}$</td>
                <td>
                  <button
                    className="btn btn-sm btn-danger"
                    onClick={() => removeFromCart(item.id)}
                  >
                    Remove
                  </button>
                  <button
                    className="btn btn-sm btn-secondary ml-1"
                    onClick={() => decrementQuantity(item.id)}
                  >
                    -
                  </button>
                  <button
                    className="btn btn-sm btn-secondary ml-1"
                    onClick={() => incrementQuantity(item.id)}
                  >
                    +
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
      <h3>Total Amount: {cart.totalAmount.toFixed(2)}$</h3>
      <button className="btn btn-primary" onClick={handleCheckout}>
        Checkout
      </button>
    </div>
  );
}

export default Cart;

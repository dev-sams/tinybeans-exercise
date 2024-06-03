import React, { createContext, useReducer } from "react";

export const CartContext = createContext();

const initialState = {
  items: [],
  totalAmount: 0,
};

const cartReducer = (state, action) => {
  switch (action.type) {
    case "ADD_TO_CART":
      const existingItem = state.items.find(
        (item) => item.id === action.payload.id
      );
      let updatedItems;
      let updatedTotalAmount;

      if (existingItem) {
        updatedItems = state.items.map((item) =>
          item.id === action.payload.id
            ? { ...item, quantity: item.quantity + 1 }
            : item
        );
        updatedTotalAmount = state.totalAmount + action.payload.price;
      } else {
        updatedItems = [...state.items, { ...action.payload, quantity: 1 }];
        updatedTotalAmount = state.totalAmount + action.payload.price;
      }

      return {
        ...state,
        items: updatedItems,
        totalAmount: updatedTotalAmount,
      };

    case "REMOVE_FROM_CART":
      const itemToRemove = state.items.find(
        (item) => item.id === action.payload.id
      );
      if (!itemToRemove) return state;

      const itemsAfterRemoval = state.items.filter(
        (item) => item.id !== action.payload.id
      );

      return {
        ...state,
        items: itemsAfterRemoval,
        totalAmount:
          state.totalAmount - itemToRemove.price * itemToRemove.quantity,
      };

    case "DECREMENT_QUANTITY":
      const itemToDecrement = state.items.find(
        (item) => item.id === action.payload.id
      );
      if (!itemToDecrement) return state;

      let updatedItemsAfterDecrement;

      if (itemToDecrement.quantity === 1) {
        updatedItemsAfterDecrement = state.items.filter(
          (item) => item.id !== action.payload.id
        );
      } else {
        updatedItemsAfterDecrement = state.items.map((item) =>
          item.id === action.payload.id
            ? { ...item, quantity: item.quantity - 1 }
            : item
        );
      }

      return {
        ...state,
        items: updatedItemsAfterDecrement,
        totalAmount: state.totalAmount - itemToDecrement.price,
      };

    case "CLEAR_CART":
      return initialState;

    default:
      return state;
  }
};

export const CartProvider = ({ children }) => {
  const [state, dispatch] = useReducer(cartReducer, initialState);

  return (
    <CartContext.Provider value={{ cart: state, dispatch }}>
      {children}
    </CartContext.Provider>
  );
};

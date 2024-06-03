import { Route, Routes } from "react-router-dom";

import Home from "./pages/Home";
import { BrowserRouter } from "react-router-dom";
import Cart from "./pages/Cart";
import Navbar from "./components/Navbar";
import { CartProvider } from "./contexts/CartContext";
import PaymentSuccess from "./pages/PaymentSuccess";
import PaymentCancel from "./pages/PaymentCancel";

function App() {
  return (
    <CartProvider>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/payment/success" element={<PaymentSuccess />} />
          <Route path="/payment/cancel" element={<PaymentCancel />} />
        </Routes>
      </BrowserRouter>
    </CartProvider>
  );
}

export default App;

import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
const toastStyle = {
  position: "top-right",
  autoClose: 5000,
  backgroundColor: "green",
};
const notificationToast = {
  success: (message) => {
    toast.success(message, toastStyle);
  },
  error: (message) => {
    toast.error(message, toastStyle);
  },
  warning: (message) => {
    toast.warning(message, toastStyle);
  },
  info: (message) => {
    toast.info(message, toastStyle);
  },
};

export default notificationToast;

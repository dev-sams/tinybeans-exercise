import { myAxios } from "./AxiosHelper";

export const createOrder = async (orderRequest) => {
  return myAxios
    .post(`/orders`, orderRequest)
    .then((response) => response.data);
};

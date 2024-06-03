import { myAxios } from "./AxiosHelper";

export const getAllItemsFromStore = async () => {
  try {
    return await myAxios.get(`/items`).then((res) => res.data);
  } catch (error) {
    throw error;
  }
};

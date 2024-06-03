import React, { useEffect, useState } from "react";
import { getAllItemsFromStore } from "../services/ItemService";
import notificationToast from "../common/ToastHelper";
import Item from "../components/Item";

function Home() {
  const [shopItems, setShopItems] = useState([]);
  const fetchAllItems = async () => {
    try {
      const response = await getAllItemsFromStore();
      if (response.statusCode === 200) {
        setShopItems(response.data);
      } else {
        notificationToast.error("Failed to fetch all items");
      }
    } catch (error) {
      notificationToast.error("Failed to fetch all items");
    }
  };
  useEffect(() => {
    fetchAllItems();
  }, []);

  return (
    <div className="container">
      <h1 className="text-center">Shop Items</h1>
      <div className="row">
        {shopItems.map((item) => (
          <div className="col-md-4" key={item.id}>
            <Item itemData={item} />
          </div>
        ))}
      </div>
    </div>
  );
}

export default Home;

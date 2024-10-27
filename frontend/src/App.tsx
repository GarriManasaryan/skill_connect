import React, { useEffect, useState } from 'react';
import logo from './tms_logo.png';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import { Breadcrumb, Layout, Menu, theme } from 'antd';
import { Content, Footer, Header } from 'antd/es/layout/layout';
import TopBarLight from './navigation/TopBarLight';
import { useAppContext } from './AppContext';
import FillerElement from './navigation/FillerElement';
import ProductsMain from './sections/products/ProductsMain';

function App() {
  const { isDarkMode } = useAppContext();

  const theme = isDarkMode ? "dark" : "light";

  useEffect(() => {
    document.documentElement.setAttribute("data-theme", theme); // "theme" could be "light" or "dark"
  }, [theme]);

  return (
  <Router>
    <div className="App" data-theme={theme}>
      <TopBarLight/>
      {/* <FillerElement/> */}
        <Routes>
          <Route path="/products" element={<ProductsMain/>}></Route>
        </Routes>
    </div>
  </Router>
);
}

export default App;

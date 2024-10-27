import React, { useEffect, useState } from 'react';
import logo from './tms_logo.png';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import { Breadcrumb, Layout, Menu } from 'antd';
import { Content, Footer, Header } from 'antd/es/layout/layout';
import TopBarLight from './navigation/TopBarLight';
import { useTheme } from './ThemeContext';

function App() {
  const { isDarkMode } = useTheme();
  return (
  <div className="App" data-theme={isDarkMode ? 'dark' : 'light'}>
    <TopBarLight/>
    <Router>
      <Routes>
        {/* <Route path="/profiles" element={<Profiles/>}></Route> */}
      </Routes>
    </Router>
  </div>
);
}

export default App;

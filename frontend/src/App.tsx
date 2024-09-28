import React from 'react';
import logo from './tms_logo.png';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import ListUsers from './elements/user/ListUsers';
import { Breadcrumb, Layout, Menu } from 'antd';
import { Content, Footer, Header } from 'antd/es/layout/layout';
import TopBar from './navigation/TopBar';
import Profiles from './elements/profile/Profiles';

function App() {
  return (
    <div className="App">
      <Router>

        <TopBar/>
        <Routes>
          <Route path="/profiles" element={<Profiles/>}></Route>
        </Routes>

      </Router>
    </div>
  );
}

export default App;

import React from 'react';
import logo from './tms_logo.png';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import ListUsers from './elements/user/ListUsers';
import { Breadcrumb, Layout, Menu } from 'antd';
import { Content, Footer, Header } from 'antd/es/layout/layout';
import TopBar from './navigation/TopBar';

function App() {
  return (
    <div className="App">
      <Router>

        <TopBar/>
        <Layout 
          style={{padding:'0 0 0 0'}}
        
        >
          {/* <Header
            style={{
              position: 'sticky',
              top: 0,
              zIndex: 1,
              width: '100%',
              display: 'flex',
              alignItems: 'center',
            }}
            >
            <Menu
              theme="light"
              mode="horizontal"
              defaultSelectedKeys={['2']}
              items={new Array(3).fill(null).map((_, index) => ({
                key: String(index + 1),
                label: `nav ${index + 1}`,
              }))}
            />
          </Header> */}
          <Content className="site-layout" style={{ padding: '0 50px' }}>
            <Breadcrumb style={{ margin: '16px 0' }}>
              <Breadcrumb.Item>Home</Breadcrumb.Item>
              <Breadcrumb.Item>List</Breadcrumb.Item>
              <Breadcrumb.Item>App</Breadcrumb.Item>
            </Breadcrumb>
            <Routes>
              {/* <Route path="/tasks" element={<ListTasks/>}></Route>
              <Route path="/test_assessments" element={<ListTestTemplates/>}></Route>
              <Route path="/view_test_assessments_test" element={<ViewTestTemplate/>}></Route> */}
              <Route path="/users" element={<ListUsers/>}></Route>
              {/* <Route path="/add_candidate" element={<AddUser/>}></Route>
              <Route path="/add_task" element={<AddTask/>}></Route>
              <Route path="/add_task_to_test/:id" element={<AddTaskToTest/>}></Route>
              <Route path="/edit_task/:id" element={<EditTask/>}></Route>
              <Route path="/:userId/:testTemplateId" element={<StartTest/>}></Route>
              <Route path="/test_processing/:id" element={<StartTest/>}></Route> */}
            </Routes>
          </Content>
        </Layout>

      </Router>
      <Footer style={{ textAlign: 'center' }}>Ant Design ©2023 Created by Ant UED</Footer>
    </div>
  );
}

export default App;

import { Button, Input, Menu, Select } from 'antd'
import { Header } from 'antd/es/layout/layout'
import { ItemType } from 'antd/es/menu/hooks/useItems'
import React from 'react'
import { Link } from 'react-router-dom'
import logo from '../sc_logo.png'
import './styles.css'
import { SearchOutlined } from '@ant-design/icons';
import { SearchProps } from 'antd/es/input/Search'


function TopBar() {

  const navigationTabs: ItemType[] = [
    {
      key: '1',
      label: 'Register'
    },
    {
      key: '2',
      label: 'Register'
    },
    {
      key: '3',
      label: 'Register'
    }
  ]

  const { Option } = Select;

  const searchOptions = (
    <Select defaultValue="Service">
      <Option value="Service">Service</Option>
      <Option value="Expert">Expert</Option>
      <Option value="Job">Job</Option>
    </Select>
  );

  const { Search } = Input;

  const onSearch: SearchProps['onSearch'] = (value) => console.log(value);

  return (

    <>
      <div
        style={{
          position: 'sticky',
          top: 0,
          zIndex: 1,
          width: '100%',
          display: 'flex',
          alignItems: 'center'
          // backgroundColor: 'black'
        }}
        >
        <Link 
          style={{padding: '1rem 0 1rem 20rem'}}
          className="logo-link" to='/image'
        >
          <img className="logo" src={logo} alt="logo"/>
        </Link>
        <Search 
          style={{width: '750px', fontSize: '20px', paddingLeft: '2rem'}}
          onSearch={onSearch}
          placeholder="Search"
          addonBefore={searchOptions} 
          // addonAfter={<SearchOutlined/>}
          allowClear
          // defaultValue="mysite" 
        />
        {/* <div className="demo-logo" /> */}
        {/* <Menu
          theme="dark"
          mode="horizontal"
          items={navigationTabs}
        /> */}
      </div>
    </>
  )
}

export default TopBar
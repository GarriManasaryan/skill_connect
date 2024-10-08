import { Button, Input, Menu, Select } from 'antd'
import { Header } from 'antd/es/layout/layout'
import { ItemType } from 'antd/es/menu/hooks/useItems'
import React from 'react'
import { Link } from 'react-router-dom'
import logo from '../sc_no_back_new.png'
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
      <div style={{
          position: 'sticky',
          top: 0,
          zIndex: 1,
          width: '100%',
          display: 'flex',
          alignItems: 'center',
          // backgroundColor: '#d5e2ff'
        }}>
        <Link 
          style={{padding: '0.5rem 0 0.5rem 30rem'}}
          className="logo-link" to='/image'
        >
          <img className="logo" src={logo} alt="logo"/>
        </Link>
        <Search 
          style={{
            width: '750px', 
            fontSize: '20px', 
            paddingLeft: '2rem'
          }}
          size='middle'
          onSearch={onSearch}
          placeholder="Search"
          addonBefore={searchOptions}
          className='addonClass'
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
import { Button, Input, Menu, Select } from 'antd'
import { Header } from 'antd/es/layout/layout'
import { ItemType } from 'antd/es/menu/hooks/useItems'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import requestIcon from './icons/order-svgrepo-com.png'
import logo_symbol from '../sc4(2).png'
// import logo_symbol from '../sc_logo.png'
import './navbar-style.css'
import { SearchOutlined } from '@ant-design/icons';
import { SearchProps } from 'antd/es/input/Search'
import ProductIcon from './icons/product/ProductIcon'
import BaseNavElement from './base/BaseNavElement'
import { hover } from '@testing-library/user-event/dist/hover'
import SpecialistsIcon from './icons/specialist/SpecialistsIcon'
import RequestsIcon from './icons/requests/RequestsIcon'
import BusinessesIcon from './icons/businesses/BusinessesIcon'
import ProductsMegaMenu from './megaMenus/ProductsMegaMenu'
import { relative } from 'path'
import ProfessionalsMegaMenu from './megaMenus/ProfessionalsMegaMenu'
import { useTheme } from '../ThemeContext'
import LogoIcon from './icons/Logo'


function TopBarLight() {

  const [logoHovered, setLogoHovered] = useState(false)

  const { isDarkMode, toggleDarkMode } = useTheme();

  return (

    <>
      <div className='navbar-container' 
        style={{
          transition: 'var(--transition)', 
        }}
      >
        <div className='navbar-left'
          onMouseEnter={() => setLogoHovered(true)}
          onMouseLeave={() => setLogoHovered(false)}
          style={{
            cursor: 'pointer',
          }}
        >
          <LogoIcon hovered={logoHovered}/>
          <div 
            style={{
              fontFamily: 'Poppins',
              fontSize: '1.6rem',
              color: logoHovered ? 'var(--text-hovered-color)' : 'var(--text-color)',
              transition: 'var(--transition)',
            }}
          >Skill Connect</div>
          {/* <div className='logo-container' >
            <img className="logo-icon" src={logo_symbol} alt="logo"/>
          </div> */}
        </div>
        <div className='navbar-middle-sections' style={{
            display: 'flex',
            gap: '50px',
            alignItems: 'center',
            position: 'relative'
          }}>
            {/* Individual specialists, like mentors, electricians etc. */}
            <BaseNavElement name='Professionals' navIcon={SpecialistsIcon} megaMenu={ProfessionalsMegaMenu} />
            <BaseNavElement name='Orders' navIcon={RequestsIcon} megaMenu={ProductsMegaMenu} />
            <BaseNavElement name='Products' navIcon={ProductIcon} megaMenu={ProductsMegaMenu} />
            {/* Organize a surprise party, go scubadiving etc - organizations */}
            <BaseNavElement name='Companies' navIcon={BusinessesIcon} megaMenu={ProductsMegaMenu} />
        </div>
        <div className='navbar-right'>
          <input 
            type='checkbox' 
            checked={isDarkMode}
            onChange={toggleDarkMode}
          />
        </div>
      </div>
    </>
  )
}

export default TopBarLight
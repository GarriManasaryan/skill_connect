import { Button, Input, Menu, Select } from 'antd'
import { Header } from 'antd/es/layout/layout'
import { ItemType } from 'antd/es/menu/hooks/useItems'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
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
import { isAbsolute, relative } from 'path'
import ProfessionalsMegaMenu from './megaMenus/ProfessionalsMegaMenu'
import { useAppContext } from '../AppContext'
import LogoIcon from './icons/Logo'
import { wrap } from 'module'
import { translations } from '../langs/i18n';

function TopBarLight() {

  const [logoHovered, setLogoHovered] = useState(false)
  const navigate = useNavigate();
  const [activeSection, setActiveSection] = useState<string | null>(null); // Track active section
  const { isDarkMode, toggleDarkMode, language, setLanguage } = useAppContext() as {
    isDarkMode: boolean;
    toggleDarkMode: () => void;
    language: 'en' | 'rus' | 'am';
    setLanguage: (lang: 'en' | 'rus' | 'am') => void;
  };

  const handleSectionClick = (section: string, url: string) => {
    setActiveSection(section);  // Set the active section
    navigate(url);              // Navigate to the URL
  };
  
  const [isMobile, setIsMobile] = useState(window.innerWidth <= 768);

  useEffect(() => {
    // Handler to update state based on window width
    const handleResize = () => {
      setIsMobile(window.innerWidth <= 768);
    };
    // Add resize event listener
    window.addEventListener('resize', handleResize);
    // Clean up event listener on component unmount
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  return (

    <>
      <div className='navbar-container' 
        style={{
          position: isMobile ? 'fixed' : 'sticky',
          top: isMobile ? 'unset' : 0,
          bottom: isMobile ? 0 : 'unset',
          transition: 'var(--transition)', 
          gap: '50px',
        }}
      >
        <div className='navbar-left'
          onMouseEnter={() => setLogoHovered(true)}
          onMouseLeave={() => setLogoHovered(false)}
          style={{
            display: 'flex',
            cursor: 'pointer',
          }}
        >
          <LogoIcon hovered={logoHovered} isActive={activeSection === 'logo'}/>
          {!isMobile && <div 
            style={{
              fontFamily: 'Poppins',
              fontSize: '1.7rem',
              color: logoHovered ? 'var(--text-hovered-color)' : 'var(--text-color)',
              transition: 'var(--transition)',
            }}
          >
            {translations[language].logo.name}
          </div>}
        </div>
        <div className='navbar-middle-sections' style={{
            display: 'flex',
            gap: isMobile ? '30px' : '50px',
            alignItems: 'center',
          }}>
            {/* Individual specialists, like mentors, electricians etc. */}
            <BaseNavElement 
              name={translations[language].navBar.professionals}
              navIcon={SpecialistsIcon} 
              megaMenu={ProductsMegaMenu}
              isMobile={isMobile}
              focused={activeSection === 'professionals'}
              onClick={() => handleSectionClick('professionals', '/professionals')}
            />
            <BaseNavElement 
              name={translations[language].navBar.orders}
              navIcon={RequestsIcon} 
              megaMenu={ProductsMegaMenu}
              isMobile={isMobile}
              focused={activeSection === 'orders'}
              onClick={() => handleSectionClick('orders', '/orders')}
            />
            <BaseNavElement 
              name={translations[language].navBar.products}
              navIcon={ProductIcon} 
              megaMenu={ProductsMegaMenu}
              isMobile={isMobile}
              focused={activeSection === 'products'}
              onClick={() => handleSectionClick('products', '/products')}
            />
            <BaseNavElement 
              name={translations[language].navBar.companies}
              navIcon={BusinessesIcon} 
              megaMenu={ProductsMegaMenu}
              isMobile={isMobile}
              focused={activeSection === 'companies'}
              onClick={() => handleSectionClick('companies', '/companies')}
            />
        </div>
        <div className='navbar-right' style={{display: 'flex', flexDirection: 'column', alignItems: 'flex-start'}}>
          <label style={{
            cursor: 'pointer',
          }}>
            <span>Dark Mode</span>
            <input
              style={{marginLeft: '15px'}} 
              type='checkbox' 
              checked={isDarkMode}
              onChange={toggleDarkMode}
            />
          </label>
          <div className='lang-select' style={{display: 'flex', flexDirection: 'row', alignItems: 'center', gap: '10px'}}>
          <label>Language:</label>
          <select id="lng" onChange={(e) => setLanguage(e.target.value as 'en' | 'rus' | 'am')}>
            <option value="en">Eng</option>
            <option value="rus">Rus</option>
            <option value="am">Arm</option>
          </select> 
          </div>
        </div>
      </div>
    </>
  )
}

export default TopBarLight
import { useState } from 'react';
import CaretIcon from '../icons/CaretIcon';
import './base-nav.css';
import style from 'antd/es/alert/style';
import { transform } from 'typescript';

interface BaseNavElementProps {
  navIcon: React.ElementType;
  name: string;              
  megaMenu: React.ElementType;
  isMobile: boolean;
  focused: boolean;
  onClick: () => void;
}

function BaseNavElement({ navIcon: NavIcon, name, megaMenu: MegaMenu, isMobile, focused, onClick }: BaseNavElementProps) {
  const [hovered, setHovered] = useState(false);
  let isActive = hovered || focused;

  return (
    <>
      <div className='base-nav-element'
        style={{
          color: isActive ? 'var(--text-hovered-color)' : 'var(--text-color)',
          fontSize: '1.2rem',
          position: 'relative',
          fontWeight: 'bold',

          // background style
          // backgroundColor: hovered || isActive ? 'var(--bg-hovered-color)' : 'transparent',

          border: isActive ? '1px solid var(--border-color)' : '1px solid transparent',
          borderRadius: '20px',
          padding: '15px',


          // padding: '25px 0 25px 0',
          
          // go up effect
          // margin: hovered || isActive ? '18px 0px 36px 0px' : '0px',

          // increase size on hover
          // transform: hovered || isActive ? 'scale(1.1)': 'scale(1)',

          transition: 'var(--transition)',
          cursor: 'pointer',
          display: 'flex',
          justifyContent: 'space-between',
          alignItems: 'center',
          gap: '6px',
        }}
        onMouseEnter={() => setHovered(true)}
        onMouseLeave={() => setHovered(false)}
        onClick={onClick}
      >
        <div className='base-nav-icon-name' style={{
          display: 'flex',
          alignItems: 'center',
          gap: '7px',
        }}>
          <NavIcon hovered={hovered} isActive={focused} />       
          <div className='base-nav-section-name' 
            style={{
            // fontSize: hovered ? '1.1em' : '1em',
            // transform: hovered ? 'scale(1.1)': 'scale(1)',
            transition: 'var(--transition)',
          }}>{name}
          </div>              
        </div>
        <CaretIcon hovered={hovered} isActive={focused}/>

        {/* Glowing Underline */}
        {/* <div
          style={{
            position: 'absolute',
            bottom: 0,
            left: '50%',
            top: '100%',
            width: hovered || isActive ? '85%' : '0', // Width expands on hover
            height: '1.5px', // Height of the underline
            background: 'var(--text-hovered-color)', // Color of the underline
            // boxShadow: hovered ? '0 -2px 8px var(--text-hovered-color)' : 'none', // Glow effect
            transform: 'translateX(-50%)', // Center alignment
            transition: 'var(--transition)', // Smooth transition
          }}
        /> */}

        {/* Megamenu - displayed only on hover */}
        {isActive ? (
          <div className="mega-menu" 
            style={{ 
              // position: 'absolute',
              // marginTop: '23rem',
              // left: '50%',     // Center alignment reference
              // transform: 'translate(-50%, 10px)', // Center horizontally and add a small vertical offset
              // width: '600px',   
              // // boxShadow: '0px 4px 8px rgba(0, 0, 0, 0.2)',
              // backgroundColor: 'var(--bg-color-level1)',
              // // opacity: isActive ? 1 : 0,
              // borderRadius: '25px',
              // padding: '20px',
              // // transition: 'opacity 1s ease', 
              // zIndex: 1000, // как в фотошопе слои, чем больше, тем выше
              // pointerEvents: isActive ? 'auto' : 'none', // Prevent interaction when hidden
              // transition: 'var(--transition)',
            }}>
              <div className='mega-menu-filler' style={{color: 'transparent', transition: 'var(--transition)',}}>filler</div>
              <MegaMenu/>
          </div>
        ) : null}
      </div>
    </>
  );
}

export default BaseNavElement;

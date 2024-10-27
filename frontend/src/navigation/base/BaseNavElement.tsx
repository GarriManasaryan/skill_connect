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
  isActive: boolean;
  onClick: () => void;
}

function BaseNavElement({ navIcon: NavIcon, name, megaMenu: MegaMenu, isMobile, isActive, onClick }: BaseNavElementProps) {
  const [hovered, setHovered] = useState(false);

  return (
    <>
      <div className='base-nav-element'
        style={{
          color: hovered || isActive ? 'var(--text-hovered-color)' : 'var(--text-color)',
          fontSize: '1.2rem',
          position: 'relative',
          // go up effect
          // padding: hovered ? '18px 0 30px 0' : '25px 0 25px 0',
          padding: '25px 0 25px 0',
          // increase size on hover
          // transform: hovered ? 'scale(1.1)': 'scale(1)',
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
          <NavIcon hovered={hovered} isActive={isActive} />       
          <div className='base-nav-section-name' 
            style={{
            // fontSize: hovered ? '1.1em' : '1em',
            // transform: hovered ? 'scale(1.1)': 'scale(1)',
            transition: 'var(--transition)',
          }}>{name}
          </div>              
        </div>
        <CaretIcon hovered={hovered} isActive={isActive}/>

        {/* Glowing Underline */}
        <div
          style={{
            position: 'absolute',
            bottom: 0,
            left: '50%',
            top: '100%',
            width: hovered || isActive ? '100%' : '0', // Width expands on hover
            height: '1.5px', // Height of the underline
            background: 'var(--text-hovered-color)', // Color of the underline
            boxShadow: hovered ? '0 -2px 8px var(--text-hovered-color)' : 'none', // Glow effect
            transform: 'translateX(-50%)', // Center alignment
            transition: 'var(--transition)', // Smooth transition
          }}
        />

        {/* Megamenu - displayed only on hover */}
        {hovered && (
          <div className="mega-menu" 
            style={{ 
              position: 'absolute',
              top: '90%',      
              left: '50%',     // Center alignment reference
              transform: hovered ? 'translate(-50%, 10px)' : 'translate(-50%, 0px)', // Center horizontally and add a small vertical offset
              width: '600px',   
              padding: '20px',  
              backgroundColor: 'var(--bg-color)',
              boxShadow: '0px 4px 8px rgba(0, 0, 0, 0.2)',
              borderRadius: '8px',
              opacity: hovered ? 1 : 0,
              // transition: 'opacity 1s ease', 
              zIndex: 1000, // как в фотошопе слои, чем больше, тем выше
              pointerEvents: hovered ? 'auto' : 'none', // Prevent interaction when hidden
            }}>
            <MegaMenu />
          </div>
        )}
      </div>
    </>
  );
}

export default BaseNavElement;

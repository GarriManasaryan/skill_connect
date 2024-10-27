import { useState } from 'react';
import CaretIcon from '../icons/CaretIcon';
import './base-nav.css';

interface BaseNavElementProps {
  navIcon: React.ElementType;  // Accept the icon component as a prop
  name: string;                // Accept name as a string
  megaMenu: React.ElementType;                // Accept name as a string
}

function BaseNavElement({ navIcon: NavIcon, name, megaMenu: MegaMenu }: BaseNavElementProps) {
  const [hovered, setHovered] = useState(false);

  return (
    <>
      <div className='base-nav-element'
        style={{
          color: hovered ? 'var(--text-hovered-color)' : 'var(--text-color)',
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
      >
        <div className='base-nav-icon-name' style={{
          display: 'flex',
          alignItems: 'center',
          gap: '7px',
        }}>
          <NavIcon hovered={hovered} />       
          <div style={{
            // fontSize: hovered ? '1.1em' : '1em',
            // transform: hovered ? 'scale(1.1)': 'scale(1)',
            transition: 'var(--transition)',
          }}>{name}</div>                
        </div>
        <CaretIcon hovered={hovered}/>
        {/* Megamenu - displayed only on hover */}
        {hovered && (
          <div className="mega-menu" 
            style={{ 
              position: 'absolute',
              top: '80%',      
              left: '50%',     // Center alignment reference
              transform: hovered ? 'translate(-50%, 10px)' : 'translate(-50%, 0px)', // Center horizontally and add a small vertical offset
              width: '600px',   
              padding: '20px',  
              backgroundColor: '#ffffff',
              boxShadow: '0px 4px 8px rgba(0, 0, 0, 0.2)',
              borderRadius: '8px',
              opacity: hovered ? 1 : 0,
              // transition: 'opacity 1s ease', 
              zIndex: 10,
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

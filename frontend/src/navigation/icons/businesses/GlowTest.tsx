import style from 'antd/es/alert/style';
import IconProps from '../common/IconProps'

function BusinessesIcon({ hovered, isActive }: IconProps) {

    const pathStyle = {
        transition: 'var(--transition)',
        strokeDasharray: 200, // Adjust based on path length for full coverage
        strokeDashoffset: hovered || isActive ? 0 : 200, // Full offset when not hovered, 0 when hovered
    };

    return (
            <svg
            width="52"
            height="52"
            viewBox="0 0 100 100"
            style={{ filter: hovered ? 'drop-shadow(0 0 5px rgba(0, 255, 255, 0.5))' : 'none' }}
            >
            <defs>
                <linearGradient id="gradient" x1="0%" y1="0%" x2="100%" y2="100%">
                <stop offset="0%" style={{ stopColor: '#00FFFF', stopOpacity: 1 }} />
                <stop offset="100%" style={{ stopColor: '#E0FFFF', stopOpacity: 1 }} />
                </linearGradient>
            </defs>
            <circle
                cx="50"
                cy="30"
                r="20"
                fill={hovered ? 'url(#gradient)' : '#00FFFF'}
            />
            <polygon
                points="30,70 70,70 50,90"
                fill={hovered ? 'url(#gradient)' : '#00FFFF'}
            />
            </svg>
    )
}

export default BusinessesIcon
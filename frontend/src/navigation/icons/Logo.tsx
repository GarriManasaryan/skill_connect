import { version } from 'os';
import path from 'path';
import IconProps from './common/IconProps'
import { transform } from 'typescript';

function LogoIcon( { hovered }: IconProps ) {

    const dimension: string = '64px'

    return (
        <div className='logo-main' style={{
            display: 'flex',
            // чтобы прокруткая была ровно по центру, надо height и width одинаковый ставить тут и в svg
            width: dimension,
            height: dimension,
            transition: 'var(--transition)',
            transform: hovered ? 'rotate(90deg)' : 'rotate(0deg)',
        }}>
            <svg width={dimension} height={dimension} viewBox="0 0 236 271" fill="none"
            stroke={hovered ? "var(--text-hovered-color)" : "var(--text-color)"}
            style={{
            transition: 'var(--transition)',
            }}
            >
                <circle cx="118" cy="136" r="31.5" stroke-width="11"/>
                <circle cx="118.5" cy="20.5" r="15" stroke-width="11"/>
                <circle cx="20.5" cy="20.5" r="15" transform="matrix(1 0 0 -1 98 271)" stroke-width="11"/>
                <circle cx="215.5" cy="74.5" r="15" stroke-width="11"/>
                <circle cx="20.5" cy="20.5" r="15" transform="matrix(1 0 0 -1 195 217)" stroke-width="11"/>
                <circle cx="20.5" cy="20.5" r="15" transform="matrix(-1 -2.10831e-08 -2.10831e-08 1 41 54)" stroke-width="11"/>
                <circle cx="20.5" cy="196.5" r="15" transform="rotate(180 20.5 196.5)" stroke-width="11"/>
                <path d="M182.586 79.9243L118 38" stroke-width="11" stroke-linecap="round"/>
                <path d="M182.586 191.076L118 233" stroke-width="11" stroke-linecap="round"/>
                <path d="M203.518 59.512L175 41" stroke-width="11" stroke-linecap="round"/>
                <path d="M203.518 211.488L175 230" stroke-width="11" stroke-linecap="round"/>
                <path d="M32.4815 59.512L61 41" stroke-width="11" stroke-linecap="round"/>
                <path d="M32.4815 211.488L61 230" stroke-width="11" stroke-linecap="round"/>
                <path d="M118 38L53.414 79.9243" stroke-width="11" stroke-linecap="round"/>
                <path d="M118 233L53.414 191.076" stroke-width="11" stroke-linecap="round"/>
                <path d="M83 93L61 75" stroke-width="11" stroke-linecap="round"/>
                <path d="M83 178L61 196" stroke-width="11" stroke-linecap="round"/>
                <path d="M66.8281 116.496L32 88" stroke-width="11" stroke-linecap="round"/>
                <path d="M66.8281 154.504L32 183" stroke-width="11" stroke-linecap="round"/>
                <path d="M200.828 88L166 116.496" stroke-width="11" stroke-linecap="round"/>
                <path d="M200.828 183L166 154.504" stroke-width="11" stroke-linecap="round"/>
                <path d="M175 74L153 92" stroke-width="11" stroke-linecap="round"/>
                <path d="M175 197L153 179" stroke-width="11" stroke-linecap="round"/>
                <path d="M133 77H103" stroke-width="11" stroke-linecap="round"/>
                <path d="M133 194H103" stroke-width="11" stroke-linecap="round"/>
                <path d="M32 117L32 155" stroke-width="11" stroke-linecap="round"/>
                <path d="M204 117L204 155" stroke-width="11" stroke-linecap="round"/>
                <path d="M175 41L175 74" stroke-width="11" stroke-linecap="round"/>
                <path d="M175 230L175 197" stroke-width="11" stroke-linecap="round"/>
                <path d="M61 41L61 74" stroke-width="11" stroke-linecap="round"/>
                <path d="M61 230L61 197" stroke-width="11" stroke-linecap="round"/>
                <path d="M102 20L88.5795 28.7115" stroke-width="11" stroke-linecap="round"/>
                <path d="M102 251L88.5795 242.288" stroke-width="11" stroke-linecap="round"/>
                <path d="M147.42 28.7115L134 20" stroke-width="11" stroke-linecap="round"/>
                <path d="M147.42 242.288L134 251" stroke-width="11" stroke-linecap="round"/>
            </svg>
        </div>
    )
}

export default LogoIcon
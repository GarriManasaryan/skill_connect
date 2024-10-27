import React, { createContext, useState, useContext, ReactNode } from 'react';

// Define context properties
const AppContext = createContext({
  isDarkMode: false,
  toggleDarkMode: () => {},
  language: 'en',
  setLanguage: (lang: string) => {},
});

// Define provider component
export const AppProvider = ({ children }: { children: ReactNode }) => {
  const [isDarkMode, setIsDarkMode] = useState(false);
  const [language, setLanguage] = useState('en');

  const toggleDarkMode = () => setIsDarkMode((prevMode) => !prevMode);

  return (
    <AppContext.Provider value={{ isDarkMode, toggleDarkMode, language, setLanguage }}>
      {children}
    </AppContext.Provider>
  );
};

// Custom hook to use AppContext
export const useAppContext = () => useContext(AppContext);
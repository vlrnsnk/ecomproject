import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import path from 'path';
import svgr from 'vite-plugin-svgr';

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    react(),
    // To use SVG
    svgr(),
  ],

  // Path alias - to use @ instead of src
  resolve: {
    alias: {
      '@': path.resolve(__dirname, 'src'),
    }
  },

  // Server configuration
  server: {
    host: '0.0.0.0',
  },
});

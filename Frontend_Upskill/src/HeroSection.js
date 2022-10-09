import React from 'react';
import './App.css';
import { Button } from './Button';
import './HeroSection.css';

function HeroSection() {
  return (
    <div className='hero-container'>
      <video src='/videos/video-2.mp4' autoPlay loop muted />
      <h1>Upskill</h1>
      <p>Grow Yourself</p>
      <div className='hero-btns'>
        
      </div>
    </div>
  );
}

export default HeroSection;

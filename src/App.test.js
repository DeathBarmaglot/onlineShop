import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
<<<<<<< HEAD
  const linkElement = screen.getByText(/Movie/i);
=======
  const linkElement = screen.getByText(/Movie Land/i);
>>>>>>> dfda3eca6e05b104d9447e021e9a1742dc7620b7
  expect(linkElement).toBeInTheDocument();
});

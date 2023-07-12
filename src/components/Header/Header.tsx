import Logo from "./Logo";
import OnlyDesktop from "./desktopUI/OnlyDesktop";
import OnlyMobile from "./mobileUI/OnlyMobile";

const Header = () => {
  return (
    <header className='sticky h-18 top-0 z-10 bg-white border-b border-gray-100 dark:bg-gray-900'>
      <div className='relative flex flex-wrap items-center justify-between mx-auto p-4'>
        <Logo />
        <OnlyDesktop />
        <OnlyMobile />
      </div>
    </header>
  );
};

export default Header;

"use client";

interface CheckboxProps {
  label: string;
  children: any;
  name: string;
  textSize?: "text-sm" | "text-md" | "text-lg";
  checked: boolean;
  onChangeHandler: React.ChangeEventHandler<HTMLInputElement>;
}

const Checkbox = (props: CheckboxProps) => {
  const { label, name, children, textSize, checked, onChangeHandler } = props;
  return (
    <div className='flex flex-col space-y-2'>
      <div className='flex items-center h-5 gap-2 '>
        <input
          type='checkbox'
          name={name}
          checked={checked}
          onChange={onChangeHandler}
          className='w-4 h-4 rounded-full text-green-600
          bg-gray-100 border-gray-300 focus:ring-green-500
          dark:focus:ring-green-600 dark:ring-offset-gray-800
          focus:ring-2 dark:bg-gray-700 dark:border-gray-600'
        />
        <label
          className={`${
            textSize ?? "text-md"
          } font-bold text-gray-900 dark:text-gray-300`}
        >
          {label}
        </label>
      </div>
      {children}
    </div>
  );
};

export default Checkbox;
